/**
 * Created by iNaS2 on 12/1/2017.
 */
function updateProposalDepartment() {
    $(function () {
        $.ajax({
            type: "POST",
            url: '/eRSPG/proposalDepartmentData',
            data: {
                'department': $('#departmentID').val(),
                'semester': $('#semesterID').val(),
                'year': $('#year').val()

            },
            datatype: 'json',
            cache: false,
            success: (data) => {
                $('#semesterID').selectedIndex = data.semester -1;
                console.log("Proposal department updated")
            }
        })
        return false;
    });
}

$(function () {
    $('#departmentID').on("blur", updateProposalDepartment);
    $('#semesterID').on("blur", updateProposalDepartment);
    $('#year').on("blur", updateProposalDepartment);

});