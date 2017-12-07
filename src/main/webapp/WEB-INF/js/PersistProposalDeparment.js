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
                $('#departmentID').val(data.department);
                $('#semesterID').selectedIndex = data.semester -1;
                $('#year').val(data.year);
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