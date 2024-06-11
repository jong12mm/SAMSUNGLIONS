const fanNavs = document.querySelectorAll('[id^=fan-nav]');
const menus = document.querySelectorAll('.menu > li > a');

menus.forEach((menu, index) => {
    const fanNav = fanNavs[index];

    menu.addEventListener('mouseenter', () => {
        fanNav.style.visibility = 'visible';
        fanNav.style.opacity = '1';
    });

    menu.addEventListener('mouseleave', () => {
        setTimeout(() => {
            if (!fanNav.matches(':hover')) {
                fanNav.style.visibility = 'hidden';
                fanNav.style.opacity = '0';
            }
        }, 200); // 200ms 후 숨김
    });

    fanNav.addEventListener('mouseenter', () => {
        fanNav.style.visibility = 'visible';
        fanNav.style.opacity = '1';
    });

    fanNav.addEventListener('mouseleave', () => {
        fanNav.style.visibility = 'hidden';
        fanNav.style.opacity = '0';
    });
});
