let seeMoreBtn = document.querySelector('div.branch_see_more');
let currentItem = 4;
seeMoreBtn.onclick = () => {
	let boxes = [...document.querySelectorAll(".branch")];
	let step = 4;
	if (currentItem + step > boxes.length) {
		step = boxes.length - currentItem
	}
	for (var i = currentItem; i < currentItem + step; i++) {
		boxes[i].style.display = 'block';
	}
	currentItem += step
	if (currentItem >= boxes.length) {
		seeMoreBtn.style.display = 'none';
	}

}

