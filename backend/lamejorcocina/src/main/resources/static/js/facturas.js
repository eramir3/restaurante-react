let numeroPlatoAdicional = 1;

$( document ).ready(function() {
	  
	$("#facturaForm").submit(function(event) {
		event.preventDefault();
		saveFactura();
	});

	$("#btnAgregarPlato").click(function() {
		agregarPlato();
	});
});


function saveFactura() {
	
	var config = {};
	jQuery($("#facturaForm")).serializeArray().map(function(item) {
	    if ( config[item.name] ) {
	        if ( typeof(config[item.name]) === "string" ) {
	            config[item.name] = [config[item.name]];
	        }
	        config[item.name].push(item.value);
	    } else {
	        config[item.name] = item.value;
	    }
	});
	
	console.log(config);

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "api/save",
		data : JSON.stringify(config),
		dataType : 'json',
		success : function(result) {
			
			if (result.status == "200") {
				alert('La factura ha sido creada con exito!');
				limpiarCampos();
			} 
			else {
				alert('Error!');
			}
		},
		error : function(e) {
			alert("Error!")
			console.log("ERROR: ", e);
		}
	});
}


function agregarPlato() {
	
	let nuevoPlato = `
		<div class="row infoPlato" id="infoPlato-`+numeroPlatoAdicional+`">
			<div class="col-3 mb-4">
				<input type="text" class="form-control" placeholder="Plato" name="nombrePlato[]" required>
			</div>
			<div class="col-3 mb-4">
				<input type="number" class="form-control" placeholder="Importe" name="importePlato[]" required>
			</div>
			<div class="col-3 mb-4">
				<button type="button" class="btn btn-danger" id="btnEliminarPlato-`+numeroPlatoAdicional+`" onclick="eliminarPlato('infoPlato-`+numeroPlatoAdicional+`')">Eliminar</button>
			</div>
		</div>
	`;
	
	
	$(nuevoPlato).appendTo($("#platos"));
	numeroPlatoAdicional++;
}


function eliminarPlato(id) {
	$("#"+id).remove();
}


function limpiarCampos() {
	
	$("#nombreCliente").val("");
	$("#apellido1Cliente").val("");
	$("#apellido2Cliente").val("");
	$("#observacionesCliente").val(""); 
	$("#plato1").val("");
	$("#importe1").val("");
	$(".infoPlato").each(function() {
		$(this).remove();
	});
}