let slider = document.querySelector(".slider");
let innerSlider = document.querySelector(".slider-inner");
let pressed = false;
let startX;
let scrollLeft;

slider.addEventListener("mousedown", (e) => {
    pressed = true;
    startX = e.pageX - slider.offsetLeft;
    scrollLeft = innerSlider.offsetLeft;
    slider.classList.add("active");
});

slider.addEventListener("mouseleave", () => {
    pressed = false;
    slider.classList.remove("active");
});

slider.addEventListener("mouseup", () => {
    pressed = false;
    slider.classList.remove("active");
});

slider.addEventListener("mousemove", (e) => {
    if (!pressed) return;
    e.preventDefault();
    const x = e.pageX - slider.offsetLeft;
    const walk = x - startX;
    innerSlider.style.left = `${scrollLeft + walk}px`;
    checkBoundary();
});

function checkBoundary() {
    let outer = slider.getBoundingClientRect();
    let inner = innerSlider.getBoundingClientRect();

    if (parseInt(innerSlider.style.left) > 0) {
        innerSlider.style.left = "0px";
    } else if (inner.right < outer.right) {
        innerSlider.style.left = `-${inner.width - outer.width}px`;

    }
}

// 중앙에 배치할 슬라이드 인덱스 설정
const targetIndex = 0; // 중앙에 배치할 슬라이드의 인덱스 (0부터 시작)

function centerSlide(index) {
    const slides = document.querySelectorAll('.slider-item');
    const targetSlide = slides[index];
    const sliderRect = slider.getBoundingClientRect();
    const targetRect = targetSlide.getBoundingClientRect();

    const offset = targetRect.left - sliderRect.left - (sliderRect.width / 2) + (targetRect.width / 2);
    innerSlider.scrollLeft += offset;
}

// 슬라이더 로드 후 중앙에 배치
window.addEventListener('load', () => {
    centerSlide(targetIndex);
});