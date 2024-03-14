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

function greet() {
    alert("Hello, World!");
}