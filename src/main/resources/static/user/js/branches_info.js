function openGoogleMaps() {
	let address = document.querySelector(".branches_info_address_link").textContent
	var url = "https://www.google.com/maps/search/?api=1&query=" + encodeURIComponent(address);
	window.open(url);
}