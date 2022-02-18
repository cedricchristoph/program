
import axios from "axios";
import { useEffect, useState } from "react";
import { isClassStaticBlockDeclaration } from "typescript";
import ApiUrl from "../../model/util/ApiUtil";
import IAsignatura from "../../model/entity/IAsignatura";
import AsignaturaCard from "../../components/asignaturas/AsignaturaCard";
import AsignaturaToolBar from "../../components/asignaturas/AsignaturasToolBar";
import { useNavigate } from 'react-router-dom';

export default function Asignaturas() {

    const [stasignaturas, setStAsignaturas] = useState<Array<IAsignatura>>([]);
    let navigate = useNavigate();

    useEffect(
        () => {
            selectAllAsignaturas();    
        }, 
        []
    );

    async function selectAllAsignaturas() {
        try {
            let {data} = await axios.get(ApiUrl() + "/asignaturas");
            let arrAsignatura: Array<IAsignatura> = data;
            console.log(arrAsignatura);
            setStAsignaturas(arrAsignatura);
        } catch {
            navigate("/connection_error");
        }
        
    }

    return (
        <>
        <div className="container">
            <h1>Asignaturas</h1>
            <div className="asignatura-wrapper">
                {stasignaturas.length === 0 ? <span className="loader"></span> : 
                <>
                {stasignaturas.map((asignatura) => <AsignaturaCard asignatura={asignatura}/>)}
                <AsignaturaToolBar/> 
                </>
                }
            </div>
        </div>
        </>
    );
}

