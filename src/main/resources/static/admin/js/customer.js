const dateInput = document.getElementById('exampleInputBirthday');
dateInput.addEventListener('blur', () => {
	const enteredDate = dateInput.value; // Lấy giá trị ngày mà người dùng vừa nhập

	if (enteredDate !== '') {
		const currentDate = new Date(enteredDate);
		const year = currentDate.getFullYear();
		let month = currentDate.getMonth() + 1;
		if (month < 10) {
			month = `0${month}`;
		}
		let day = currentDate.getDate();
		if (day < 10) {
			day = `0${day}`;
		}
		const formattedDate = `${year}-${month}-${day}`;
		dateInput.value = formattedDate;
	}
});