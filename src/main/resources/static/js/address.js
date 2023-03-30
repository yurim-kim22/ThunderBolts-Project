

window.onclick = function(event) {

    var modal1 = document.getElementById("address_modal");
    var btn1 = document.getElementById("open-modal1");
    var close1 = document.getElementsByClassName("close")[0];

    btn1.onclick = function() {
        modal1.style.display = "block";
    }

    close1.onclick = function() {
        modal1.style.display = "none";
    }
}