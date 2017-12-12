

function updateAnswers() {
    $(function () {
        $.ajax({
            type: "POST",
            url: '/eRSPG/proposalBodyData',
            data: {

            },
            datatype: 'json',
            cache: false,
            success: () => {
                console.log("Answers updated : SUCCESS");
            }
        })
        return false;
    });
}
