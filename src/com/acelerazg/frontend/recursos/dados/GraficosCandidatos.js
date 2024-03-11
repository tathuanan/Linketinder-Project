"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.GraficosCandidatos = void 0;
const auto_1 = __importDefault(require("chart.js/auto"));
const ListaPessoa_1 = require("./ListaPessoa");
class GraficosCandidatos {
    static gerarGrafico() {
        const buscarCompetencias = {};
        ListaPessoa_1.ListaPessoa.candidatos.forEach(candidato => {
            candidato.competencias.forEach(competencia => {
                if (buscarCompetencias[competencia]) {
                    buscarCompetencias[competencia]++;
                }
                else {
                    buscarCompetencias[competencia] = 1;
                }
            });
        });
        const competencias = Object.keys(buscarCompetencias);
        const dados = Object.values(buscarCompetencias);
        const canvas = document.getElementById('competenciasChart');
        if (!canvas) {
            throw new Error("Elemento HTML com o ID 'competenciasChart' não encontrado.");
        }
        const chart = new auto_1.default(canvas, {
            type: 'bar',
            data: {
                labels: competencias,
                datasets: [{
                        label: 'Número de Candidatos por Competência',
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
exports.GraficosCandidatos = GraficosCandidatos;
