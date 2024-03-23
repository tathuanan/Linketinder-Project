"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Regex = void 0;
class Regex {
    static validarNome(nome) {
        const regex = /^[\ba-zA-ZÀ-ÿ]+( [\ba-zA-ZÀ-ÿ]+)+$/g;
        return regex.test(nome);
    }
}
exports.Regex = Regex;
