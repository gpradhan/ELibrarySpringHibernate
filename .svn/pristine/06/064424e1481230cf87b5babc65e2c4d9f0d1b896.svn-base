//function preventBack() {
//	window.history.forward();
//}
//setTimeout("preventBack()", 0);
//window.onunload = function() {
//	null
//};

//disable back button
history.pushState(null, null, location.href);
window.onpopstate = function () {
    history.go(1);
};

//disable refresh button
$(function () {  
    $(document).keydown(function (e) {  
        return (e.which || e.keyCode) != 116;  
    });  
}); 