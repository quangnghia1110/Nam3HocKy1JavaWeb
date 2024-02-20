const selectEle = document.querySelector('#exampleInputRole');
const selectBranch = document.querySelector('.idBranchBlock');
selectEle.addEventListener('change', () => {
	const val = selectEle.value;
	console.log(val);
	if(val === "MANAGER") {
		selectBranch.classList.remove('d-none');
		selectBranch.classList.add('d-block');
	}
})