/**
 * file 여러개 추가하는 js 
 */

		const imgList = document.getElementById("imgList");

		let count = 0;
		let max = 4;
		let param = 'boardFiles';
		let idx = 1;

		function setCount(c){
		    count = c;
		}

		function setMax(m) {
		    max = m;
		};

		function setParam(p) {
		    param = p;
		}

		//추가
		$('#fileInsert').click(()=>{
		        if(count >= max) {
		            alert("이미지는 최대 " + (max+1) + "개까지 업로드 가능합니다")
		            return;
		        } 
		        
		        count++;
		        
		        let child = '<div class="fw-bold fs-5 col-12 my-1 input-group" id="img'+idx+'">';
		            child = child + '<input type="file" class="form-control" name="'+param+'">'
		            child = child + '<button type="button" class="btn btn-outline-danger btn-image delete" data-delete-id="img'+idx+'">x</button>'
		        $('#imgList').append(child);
		        idx++;
		})

		//삭제
		$('#imgList').on('click', '.delete', function(e){
		    $(this).parent().remove();
		    count--;
		})

 