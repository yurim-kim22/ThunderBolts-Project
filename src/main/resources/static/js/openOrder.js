document.getElementById("orderupdate").onclick = function() {
    window.open("Orderupdate.html", "Order Update", "width=1366,height=768");
}

document.getElementById("orderdelete").onclick = function() {
    window.open("Orderdelete.html", "Order Delete", "width=1366,height=768");
}

document.getElementById("select").onclick = function() {
	window.location.href = "../templates/admin/order/list.html"
}