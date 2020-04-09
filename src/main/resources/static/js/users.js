  function validateForm() {

      //var x = document.forms["myForm"]["fname"].value;
        var x = document.getElementsById("fname");
      if (x == "") {
        alert("Name must be filled out");
        return false;
      }

       alert("Name " + x);
  }