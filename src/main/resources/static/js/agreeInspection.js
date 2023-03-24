
          const modalBtn1 = document.getElementById("modalBtn1");
         
          const modal1 = document.getElementById("modal1");
      
          const closeBtns = document.getElementsByClassName("close");
          const accordions = document.getElementsByClassName("accordion");

          modalBtn1.onclick = () => {
            modal1.style.display = "block";
          };


          for (let closeBtn of closeBtns) {
            closeBtn.onclick = (event) => {
              event.target.parentElement.parentElement.style.display = "none";
            };
          }
          for (let accordion of accordions) {
            accordion.onclick = () => {
              const otherAccordions = Array.from(accordions).filter(acc => acc !== accordion);
              otherAccordions.forEach(otherAcc => {
                otherAcc.classList.remove("active");
                otherAcc.nextElementSibling.style.display = "none";
              });

              accordion.classList.toggle("active");
              const panel = accordion.nextElementSibling;
              if (panel.style.display === "block") {
                panel.style.display = "none";
              } else {
                panel.style.display = "block";
              }
            };
          }

          window.onclick = (event) => {
            if (event.target === modal1) {
              event.target.style.display = "none";
            }
          };

          let currentContentId = null;

          function toggleContent(contentId) {
            let content = document.getElementById(contentId);
            if (contentId === currentContentId) {
              content.style.display = 'none';
              currentContentId = null;
            } else {
              if (currentContentId) {
                let currentContent = document.getElementById(currentContentId);
                currentContent.style.display = 'none';
              }
              content.style.display = 'block';
              currentContentId = contentId;
            }
          }

