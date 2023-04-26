package com.porfolio.svv.Interface;

import com.porfolio.svv.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    //Traer lista de personas
    public List<Persona> getPersona();
    
    //Guardar objeto de tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto desde el ID
    public void deletePersona(Long Id);
    
    //Buscar perosona por ID
    public Persona findPersona(Long id);
}
