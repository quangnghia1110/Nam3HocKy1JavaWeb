const listDesc = document.querySelectorAll('.cart-modify-quantity-desc');
const listAsc = document.querySelectorAll('.cart-modify-quantity-asc');
const listQuantity = document.querySelectorAll('.cart-quantity-input');
const checkboxAll = document.querySelector('.checkbox-select-all');
const listCheckbox = document.querySelectorAll('.checkbox-element');
const listPrice = document.querySelectorAll('.cart-price');
const sumPriceEle = document.querySelector('.cart-sum-price');
const btnSubmit = document.querySelector('.cart-btn-submit');
const listDeleteBtn = document.querySelectorAll('.cart-btn-delete');
const listCartSize = document.querySelectorAll('.cart-size');

listPrice.forEach(function(item, index) {
	var price = listPrice[index].textContent;
	price = price.slice(0, -1);
	price = parseInt(price);
	if (listCartSize[index].textContent === "Lớn") {
		price += 5000;
	}
	item.textContent = price + "đ";
})

listDesc.forEach(function(btnDesc) {
	btnDesc.addEventListener('click', function() {
		var quantityInput = btnDesc.nextElementSibling;
		var currentValue = parseInt(quantityInput.value);
		if (currentValue > 1) {
			currentValue -= 1;
		}
		quantityInput.value = currentValue;
		calculateSumPrice();
	})
})

listAsc.forEach(function(btnAsc) {
	btnAsc.addEventListener('click', function() {
		var quantityInput = btnAsc.previousElementSibling;
		var currentValue = parseInt(quantityInput.value);
		currentValue += 1;
		quantityInput.value = currentValue;
		calculateSumPrice();
	})
})

checkboxAll.addEventListener('click', function() {
	listCheckbox.forEach(function(item) {
		item.checked = checkboxAll.checked;
	})
})

listCheckbox.forEach(function(btn) {
	btn.addEventListener('click', function() {
		calculateSumPrice();
	})
})

checkboxAll.addEventListener('click', function() {
	calculateSumPrice();
})

function calculateSumPrice() {
	var sumPrice = 0;
	listCheckbox.forEach(function(item, index) {
		if (item.checked) {
			let val = listPrice[index].textContent;
			val = val.slice(0, -1);
			sumPrice += parseInt(val) * parseInt(listQuantity[index].value);
		}
	})
	sumPriceEle.textContent = sumPrice + 'đ';
}


btnSubmit.addEventListener("click", function() {
	const data = {};
	data.list = [];
	listCheckbox.forEach(function(item, index) {
		if (item.checked) {
			const obj = {};
			obj.idMilkTea = item.value;
			obj.quantity = parseInt(listQuantity[index].value);
			let val = listPrice[index].textContent;
			val = val.slice(0, -1);
			obj.price = parseInt(val);
			obj.size = listCartSize[index].textContent;
			data.list.push(obj);
		}
	})
	data.totalProduct = 0;
	data.totalPrice = 0;
	data.list.forEach(function(item, index) {
		data.totalProduct += item.quantity;
		data.totalPrice += item.price * item.quantity;
	})
	var encodedJSONdata = encodeURIComponent(JSON.stringify(data));
	function customBase64Encode(str) {
		return btoa(unescape(encodeURIComponent(str)));
	}

	var encodedData = customBase64Encode(JSON.stringify(data));
	var myAnchor = document.createElement('a');
	var noChoose = "false";
	if(sumPriceEle.textContent === "0đ") {
		noChoose = "true";
	}
	myAnchor.setAttribute('href', '/cart/check?data=' + encodedData + "&noChoose="+noChoose);
	myAnchor.click();
})

listDeleteBtn.forEach(function(item, index) {
	item.addEventListener('click', function(e) {
		document.querySelector('.modal-product-id').textContent = listDeleteBtn[index].getAttribute('data-id');
		document.querySelector('.modal-product-name').textContent = listDeleteBtn[index].getAttribute('data-name');
		document.querySelector('.modal-product-size').textContent = listCartSize[index].getAttribute('data-name');
	})
})

document.querySelector('.btn-yes').addEventListener('click', function() {
	var myAnchor = document.createElement('a');
	var idMilkTea = document.querySelector('.modal-product-id').textContent;
	var size = document.querySelector('.modal-product-size').textContent;
	idMilkTea = parseInt(idMilkTea);
	myAnchor.setAttribute('href', '/cart/delete/?idMilkTea=' + idMilkTea + '&&size=' + size);
	myAnchor.click();
})

listQuantity.forEach(function(item, index) {
	item.addEventListener("keyup", function() {
		var inputVal = item.value;
		var number = parseInt(inputVal);

		function checkIfStringIsNumeric(inputString) {
			return !isNaN(inputString) && !isNaN(parseFloat(inputString));
		}

		if (checkIfStringIsNumeric(inputVal) && number > 0) {
			calculateSumPrice();
		} else {
			item.value = inputVal.slice(0, -1);
		}
	})

	item.addEventListener("blur", function() {
		var inputVal = item.value;

		if (inputVal == "") {
			item.value = "1";
			calculateSumPrice();
		}
	})
})



