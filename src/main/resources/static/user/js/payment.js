const address = document.querySelector('#addressInp');
const phoneNumber = document.querySelector('#phoneNumberInp');
const listRadio = document.querySelectorAll('.form-check-input-radio');
const note = document.querySelector('#exampleFormControlTextarea1');
const price = document.querySelector('.payment-price-val');
const product = document.querySelector('.payment-product');
const fee = document.querySelector('.payment-fee');
const finalPrice = document.querySelector('.payment-final-price');
const orderDay = document.querySelector('.payment-order-day');
const shipDay = document.querySelector('.payment-ship-day');
const paymentBtn = document.querySelector('.payment-btn');
const agreeCheckbox = document.querySelector('#flexCheckDefault');
const placeResult = document.querySelector('.places-result');
let listPlaceItem = document.querySelectorAll('.places-result-item');
const listFee = document.querySelectorAll('.branch-fee-val');
const listRadioBranch = document.querySelectorAll('.radio-branch');
const listBranchAddress = document.querySelectorAll('.list-branches-item-address');

let timeoutId = null;
let shipAddress = "";

function convertToDateTime(dateString) {
	const date = new Date(dateString);

	const year = date.getFullYear();
	const month = String(date.getMonth() + 1).padStart(2, '0');
	const day = String(date.getDate()).padStart(2, '0');
	const hours = String(date.getHours()).padStart(2, '0');
	const minutes = String(date.getMinutes()).padStart(2, '0');
	const seconds = String(date.getSeconds()).padStart(2, '0');

	const formattedDateTime = `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;

	return formattedDateTime;

}

var currentDate = new Date();
orderDay.textContent = convertToDateTime(currentDate.toISOString());
shipDay.textContent = convertToDateTime(currentDate.toISOString());

function convertToVal(str) {
	str = str.slice(0, -1);
	console.log(str);
	return parseInt(str);
}

finalPrice.textContent = convertToVal(price.textContent) + convertToVal(fee.textContent) + 'đ';

paymentBtn.addEventListener('click', function() {
	var dataJSON = document.querySelector('.payment-content').getAttribute('data-name');
	console.log(dataJSON);
	data = JSON.parse(dataJSON);
	var orderData = {};
	orderData.address = address.value;
	orderData.phoneNumber = phoneNumber.value;
	orderData.note = note.value;
	orderData.totalPrice = convertToVal(price.textContent);
	orderData.totalProduct = parseInt(product.textContent);
	orderData.finalPrice = convertToVal(finalPrice.textContent);
	orderData.orderDay = orderDay.textContent;
	orderData.shipDay = shipDay.textContent;
	orderData.fee = convertToVal(fee.textContent);
	listRadioBranch.forEach((item) => {
		if (item.checked) {
			orderData.idBranch = item.getAttribute('data-id');
		}
	})
	listRadio.forEach(function(item) {
		if (item.checked) {
			orderData.idPayMethod = item.getAttribute('data-id');
		}
	})
	const check = orderData.idPayMethod == 'VNPay';

	if (!agreeCheckbox.checked) {
		alert('Bạn cần đồng ý với điều khoản trước khi thanh toán.');
		return;
	}

	orderData.list = data.list;
	orderData.orderState = 0;
	function customBase64Encode(str) {
		return btoa(unescape(encodeURIComponent(str)));
	}

	var encodedData = customBase64Encode(JSON.stringify(orderData));
	var myAnchor = document.createElement('a');

	if (check) {
		myAnchor.setAttribute('href', '/api/payment/create_payment?cost=' + orderData.finalPrice + '&data=' + encodedData);
	}
	else {
		myAnchor.setAttribute('href', '/payment/order?data=' + encodedData);
	}
	myAnchor.click();
})

/*google map*/
function callPlacesAPI(query) {
	const url = `http://localhost:8989/api/places?query=${query}`;
	return new Promise((resolve, reject) => {
		fetch(url)
			.then(response => {
				if (!response.ok) {
					throw new Error('Network response was not ok.');
				}
				return response.json();
			})
			.then(data => {
				resolve(data);
			})
			.catch(error => {
				reject(error);
			});
	});
}

function addPlace(value) {
	address.value = value;
	placeResult.innerHTML = '';
}

const getListPlace = async (query) => {
	const places = await callPlacesAPI(query);
	let listPlaces = places.results;
	if (listPlaces.length > 6) {
		listPlaces = listPlaces.slice(0, 5);
	}
	const liElements = listPlaces.reduce((html, place, index) => {
		html += `<li class="places-result-item" onclick="addPlace('${place.formatted_address}')">${place.formatted_address}</li>`;
		return html;
	}, '');
	placeResult.innerHTML = liElements;
}

address.addEventListener("keyup", function() {
	clearTimeout(timeoutId);
	timeoutId = setTimeout(() => {
		getListPlace(address.value);
		listPlaceItem = document.querySelectorAll('.places-result-item');
	}, 300);
})

/*Calculate Ship Price*/
function callShipPriceAPI(origins, destinations, units) {
	const url = `http://localhost:8989/api/calculateDistance?origins=${origins}&destinations=${destinations}&units=${units}`;
	return new Promise((resolve, reject) => {
		fetch(url)
			.then(response => {
				if (!response.ok) {
					throw new Error('Network response was not ok.');
				}
				return response.json();
			})
			.then(data => {
				console.log(data);
				resolve(data);
			})
			.catch(error => {
				reject(error);
			});
	});
}

function calculateShipPriceBaseOnDistance(distance) {
	const matchResult = distance.match(/^\d+(\.\d+)?/);
	let distanceNumber = 10000;
	if (matchResult) {
		distanceNumber = parseFloat(matchResult[0]);
		distanceNumber = parseInt(distanceNumber * 2);
		distanceNumber *= 1000;
	}
	return distanceNumber;
}

function calculateShipDayBaseOnDistance(duration) {
	const matchResult = duration.match(/^\d+(\.\d+)?/);
	let futureDate = currentDate;
	if (matchResult) {
		let time = parseFloat(matchResult[0]);
		time = time * 60 * 1000;
		futureDate = new Date(currentDate.getTime() + time);
	}
	return convertToDateTime(futureDate);
}

const getDataOfAPI = async (destination) => {
	const data = await callShipPriceAPI(address.value, destination, "DRIVER");
	return data.rows[0].elements[0];
}

const calculateAllShipPrice = () => {
	listBranchAddress.forEach(async (address, index) => {
		const dataObj = await getDataOfAPI(address.textContent);
		const feeVal = calculateShipPriceBaseOnDistance(dataObj.distance.text);
		listFee[index].textContent = feeVal + "đ";
		if (listRadioBranch[index].checked) {
			fee.textContent = feeVal + "đ";
			finalPrice.textContent = feeVal + convertToVal(price.textContent) + "đ";
			shipDay.textContent = calculateShipDayBaseOnDistance(dataObj.duration.text);
		}
	})
}

address.addEventListener('blur', function() {
	setTimeout(() => {
		calculateAllShipPrice();
	}, 500);
})

listRadioBranch.forEach((radio, index) => {
	radio.addEventListener('change', async () => {
		if (radio.checked) {
			fee.textContent = listFee[index].textContent;
			finalPrice.textContent = convertToVal(listFee[index].textContent) + convertToVal(price.textContent) + "đ";
			shipAddress = listBranchAddress[index].textContent;
			const dataObj = await getDataOfAPI(shipAddress);
			shipDay.textContent = calculateShipDayBaseOnDistance(dataObj.duration.text);
		}
	});
});





