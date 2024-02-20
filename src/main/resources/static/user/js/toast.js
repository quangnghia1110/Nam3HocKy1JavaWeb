const main = document.querySelector("#toast");
const toast = document.querySelector(".toast");
const toastClose = document.querySelector('.toast__close');
const autoRemove = setTimeout(() => {
    if (main && toast) {
        main.removeChild(toast);
    }
}, 5000);

toastClose.onclick = (e) => {
    if (main && toast) {
        main.removeChild(toast);
    }
    clearTimeout(autoRemove);
};
