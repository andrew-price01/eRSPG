function setNextPage(dest, prefix) {
	document.getElementById("nextPage").value = dest;
    window.location.href = prefix + dest;
    
    document.getElementsByTagName("FORM")[0].submit();
    
    return dest;
}
