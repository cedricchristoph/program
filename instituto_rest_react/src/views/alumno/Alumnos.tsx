
import axios from "axios";
import { useEffect, useState } from "react";
import { isClassStaticBlockDeclaration } from "typescript";
import AlumnoCard from "../../components/alumno/AlumnoCard";
import IAlumno from "../../model/entity/IAlumno";
import ApiUrl from "../../model/util/ApiUtil";
import AlumnosToolBar from "../../components/alumno/AlumnosToolBar";
import { useNavigate } from 'react-router-dom';

export default function Alumnos() {

    const [stalumnos, setStAlumnos] = useState<Array<IAlumno>>([]);
    
    let navigate = useNavigate();

    useEffect(
        () => {
            async function selectAllAlumnos() {
                try {
                    let {data} = await axios.get(ApiUrl() + "/alumnos");
                    let arrAlumno: Array<IAlumno> = data;
                    console.log(data);
                    setStAlumnos(arrAlumno);
                } catch {
                    navigate("/connection_error");
                }
            }            
            selectAllAlumnos();    
        }, 
        []
    );



    return (
        <>
        <div className="container">
            <h1>Alumnos</h1>
            <div className="alumno-wrapper">
            { stalumnos.length === 0 ? <span className="loader"></span> : stalumnos.map((alumno) => <AlumnoCard alumno={alumno}/>)}
            </div> 
            <AlumnosToolBar />
        </div>
        </>
    );
}

