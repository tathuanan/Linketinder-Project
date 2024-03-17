import Chart from "chart.js/auto";
import { ListaPessoa } from "./ListaPessoa";

export class GraficosCandidatos {

    public static gerarGrafico(): object {
        const buscarCompetencias: any = {};

        ListaPessoa.candidatos.forEach(candidato => {
            candidato.competencias.forEach(competencia => {
                if (buscarCompetencias[competencia]) {
                    buscarCompetencias[competencia]++;
                } else {
                    buscarCompetencias[competencia] = 1;
                }
            });
        });

        const competencias = Object.keys(buscarCompetencias);
        const dados = Object.values(buscarCompetencias);
        const canvas = document.getElementById('competenciasChart') as HTMLCanvasElement;

        if (!canvas) {
            throw new Error("Elemento HTML com o ID 'competenciasChart' não encontrado.");
        }

        const chart = new Chart(canvas, {
            type: 'bar',
            data: {
                labels: competencias,
                datasets: [{
                    label: 'Quantidade de Candidatos por Competência',
                    data: dados,
                    backgroundColor: 'rgba(75, 192, 192, 0.6)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1.5,
                    hoverBackgroundColor: '#111b21',
                }]
            },
            options: {
                scales: {
                    x: {
                        ticks: {
                            color: 'white'
                        }
                    },
                    y: {
                        beginAtZero: true,
                        ticks: {
                            color: 'white',
                            stepSize: 1,
                        }
                    }
                },
                layout: {
                    padding: {
                        top: 5,
                    }
                },
                plugins: {
                    legend: {
                        labels: {
                            color: 'white'
                        }
                    }
                }
            }
        });

        return chart;
    }
}
