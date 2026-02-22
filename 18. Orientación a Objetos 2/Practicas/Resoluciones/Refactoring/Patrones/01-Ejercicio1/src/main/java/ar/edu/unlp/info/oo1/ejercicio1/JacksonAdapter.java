package ar.edu.unlp.info.oo1.ejercicio1;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonAdapter extends VoorheesExporter{
	@Override
	
	/**
	 * Convierte una lista de socios en una cadena JSON usando Jackson ObjectMapper.
	 * Retorna el JSON resultante o una cadena vacía si ocurre un error durante la serialización.
	 */
	
	public String exportar(List<Socio> socios) {
		 ObjectMapper mapper = new ObjectMapper();
		 String data = "";

		 try {
			   data = mapper.writeValueAsString(socios);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		 return data;
	}
}
