$(function () {
    $(document).scroll(function () {
        var $nav = $("#mainNavbar");
        $nav.toggleClass("scrolled", $(this).scrollTop() > $nav.height());
    });
});

$("#navbarToggler").on("click", function () {
    var $nav = $("#mainNavbar");
    $nav.toggleClass("shadowed");
});

$(document).ready(function () {
    $(document).click(function (event) {
        var clickover = $(event.target);
        var _opened = $(".navbar-collapse").hasClass("show");
        if (_opened === true && !clickover.hasClass("navbar-toggler")) {
            $(".navbar-toggler").click();
        }
    });
});

function greet() {
    alert("Hello, World!");
}

function goBackOneLevel() {
    // Get the current URL
    var currentUrl = window.location.href;
    // Find the last occurrence of "/"
    var lastSlashIndex = currentUrl.lastIndexOf("/");
    // Extract the base URL up to the last slash
    // Navigate to the base URL
    window.location.href = currentUrl.substring(0, lastSlashIndex);
}