import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams, Navigate, Route, Link, useNavigate } from "react-router-dom";
import IAlumno from '../../model/entity/IAlumno';
import ApiUrl from '../../model/util/ApiUtil';
import StringUtils from '../../model/util/StringUtils';

interface IProps {}
interface IState {alumno: IAlumno}

export default function AddAlumno() {
    
    const [stalumno, setStAlumno] = useState<IState>();
    let {dni} = useParams();
    let navigate = useNavigate();
    
    useEffect(() => {
        
    }, []);

    function save (event:React.FormEvent<HTMLFormElement>) {
        event.preventDefault();
        let formulario: HTMLFormElement = event.currentTarget;
        let inputdni: HTMLInputElement = formulario.dni;
        let inputnombre: HTMLInputElement = formulario.nombre;
        let inputapellidos: HTMLInputElement = formulario.apellidos;
        let inputfecha: HTMLInputElement = formulario.fecha;
        let alumno: IAlumno = {
            dni: inputdni.value.toString(),
            nombre: inputnombre.value.toString(),
            apellidos: inputapellidos.value.toString(),
            fechanacimiento: new Date(inputfecha.value.toString()).getTime()
        };
        const asyncsave = async () => {
            try {
                console.log(alumno);
                let { data } = await axios.post(ApiUrl() + "/alumnos", alumno);
            } catch {
                console.log("Error");
            } finally {
                navigate("/");
            }
        }
        asyncsave();
    }

    return (
        <>
        <div className='container'>
            <h1>Registrar un nuevo alumno</h1>
            <form onSubmit={save}>
                <label>DNI</label><br/>
                <input type="text" id="dni" placeholder='Introducir DNI'/><br/>
                <label>Nombre</label><br/>
                <input type="text" id="nombre" placeholder='Introducir Nombre' /><br/>
                <label>Apellidos</label><br/>
                <input type="text" id="apellidos" placeholder='Introducir apellidos' /><br/>
                <label>Fecha de Nacimiento</label><br/>
                <input type="date" id="fecha" placeholder='Introducir fecha de nacimiento'/><br/>
                <input className="submit-button" type="submit" value="Guardar"/>
            </form>
        </div>
        </>
    );

}