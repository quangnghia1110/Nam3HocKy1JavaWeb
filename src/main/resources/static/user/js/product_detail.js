var buyNowBtn = document.querySelector('.buy-now-btn');
var idMilkTea = parseInt(document.querySelector('#card-id').getAttribute('data-name'));
var data = {};
data.list = [];
var obj = {};
obj.idMilkTea = idMilkTea;
obj.size = "Vừa";
obj.quantity = 1;
obj.price = parseInt(document.querySelector('.price').getAttribute('data-name'));
data.list.push(obj);
data.totalProduct = 1;
data.totalPrice = obj.price;
function changeSize(size) {
	var addToCartBtn = document.querySelector('.add-to-cart-btn');

	var mediumSizeBtn = document.querySelector('.medium-size-btn');
	var largeSizeBtn = document.querySelector('.large-size-btn');
	obj.size = size;
	if (size == 'Lớn') {
		mediumSizeBtn.classList.remove('active');
		largeSizeBtn.classList.add('active');
		
		data.list[0].price += 5000;

		addToCartBtn.href = `/product_detail/addtocart?id=${idMilkTea}&&size=Lớn`;

	} else if (size == 'Vừa') {
		mediumSizeBtn.classList.add('active');
		largeSizeBtn.classList.remove('active');
		if(obj.price != parseInt(document.querySelector('.price').getAttribute('data-name'))) {
			data.list[0].price -= 5000;
		}

		addToCartBtn.href = `/product_detail/addtocart?id=${idMilkTea}&&size=Vừa`;
	}
	data.totalPrice = obj.price;
}

buyNowBtn.addEventListener('click', function() {
	function customBase64Encode(str) {
		return btoa(unescape(encodeURIComponent(str)));
	}
	var encodedData = customBase64Encode(JSON.stringify(data));
	var myAnchor = document.createElement('a');
	myAnchor.setAttribute('href', "/product_detail/check?data=" + encodedData);
	myAnchor.click();
})