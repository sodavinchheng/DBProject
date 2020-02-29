function showForm(formId) {
    var i, forms
    forms = document.getElementsByClassName("my-form")
    for (i = 0; i < forms.length; i++) {
        forms[i].style.display = "none"
    }
    document.getElementById(formId).style.display = "block"
}