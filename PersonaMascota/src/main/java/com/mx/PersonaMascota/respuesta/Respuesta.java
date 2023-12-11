package com.mx.PersonaMascota.respuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {
	String mensaje;
	boolean success;
	Object obj;
}
