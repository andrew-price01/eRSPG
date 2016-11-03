function setNextPage(dest, prefix) {
	document.getElementById("nextPage").value = dest;
    window.location.href = prefix + dest;
    
    return dest;
}
