/* Set the width of the side navigation to 250px and the left margin of the page content to 250px */
function openNav() {
  document.getElementById("mysidenav").style.width = "160px";
  document.getElementById("main").style.marginLeft = "160px";
}

/* Set the width of the side navigation to 0 and the left margin of the page content to 0 */
function closeNav() {
  document.getElementById("mysidenav").style.width = "0";
  document.getElementById("main").style.marginLeft = "0";
}

// Hamburger
// Look for .hamburger
var hamburger = document.querySelector(".hamburger");
// On click
hamburger.addEventListener("click", function () {
  closeNav();
  // Toggle class "is-active"
  if (hamburger.classList.toggle("is-active")) {
    openNav();
  } else {
    closeNav();
  }
});
