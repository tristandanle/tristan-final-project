$(document).ready(function() {
	    	   // Cancel button
	    	   $("#buttonCancel").on("click", function() {
	    	    	  //window.location = "[[@{/users}]]";
	    	    	  window.location = cancelURL;
	    	      }) ;
	    	   
	           // File image
	           $("#fileImage").change(function() {
				fileSize = this.files[0].size;
				
				if (fileSize > 1048576) {
					this.setCustomValidity("You must choose an image less than 1MB!");
					this.reportValidity();
				} else {
					this.setCustomValidity("");
					showImageThumbnail(this);				
				}
	           });
	         // End File image
	       });
	     // END $document
	     
	     // function display photo image thumbnail
	     function showImageThumbnail(fileInput) {
			var file = fileInput.files[0];
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#thumbnail").attr("src", e.target.result);
			};
			
			reader.readAsDataURL(file);
	     }  // End 