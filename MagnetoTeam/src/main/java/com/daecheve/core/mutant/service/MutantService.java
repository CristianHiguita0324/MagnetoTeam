package com.daecheve.core.mutant.service;

import com.daecheve.core.mutant.model.Mutant;
import com.daecheve.core.mutant.port.MutantPort;
import java.util.Arrays;

/**
 *
 * @author daecheve
 */
public class MutantService {

    private MutantPort mutantPort;

    public MutantService(MutantPort mutantPort) {
        this.mutantPort = mutantPort;
    }

    public Boolean isMutant(String[] dna) {
        boolean answer = matchDna(parseArrayToMatrix(dna));

        Mutant mutant = new Mutant();
        mutant.setDna(Arrays.toString(dna));
        mutant.setIsMutant(Byte.parseByte(answer ? "1" : "0"));
        mutantPort.save(mutant);

        return answer;
    }

    public long countByIsMutant(byte isMutant) {
        return mutantPort.countByIsMutant(isMutant);
    }

    private boolean matchDna(char[][] dna) {
        int contMutant = 0;

        for (int y = 0; y < dna.length; y++) {
            for (int x = 0; x < dna.length; x++) {

                contMutant = contMutant + findAxisX(x, y, dna);
                contMutant = contMutant + findAxisY(x, y, dna);
                contMutant = contMutant + findAxisXY(x, y, dna);

                if (contMutant > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private int findAxisX(int x, int y, char[][] dna) {
        return x < dna.length - 3
                && Boolean.TRUE.equals(compareSequence(dna[y][x], dna[y][x + 1],
                        dna[y][x + 2], dna[y][x + 3])) ? 1 : 0;
    }

    private int findAxisY(int x, int y, char[][] dna) {
        return y < dna.length - 3
                && Boolean.TRUE.equals(compareSequence(dna[y][x], dna[y + 1][x],
                        dna[y + 2][x], dna[y + 3][x])) ? 1 : 0;
    }

    private int findAxisXY(int x, int y, char[][] dna) {
        int answer = 0;
        if (x < dna.length - 3 && y < dna.length - 3) {
            if (Boolean.TRUE.equals(compareSequence(dna[y][x],
                    dna[y + 1][x + 1], dna[y + 2][x + 2], dna[y + 3][x + 3]))) {
                answer++;
            }

            if (Boolean.TRUE.equals(compareSequence(dna[y][5 - x],
                    dna[y + 1][4 - x], dna[y + 2][3 - x], dna[y + 3][2 - x]))) {
                answer++;
            }
        }
        return answer;
    }

    private boolean compareSequence(char char1, char char2, char char3, char char4) {
        return char1 == char2 && char2 == char3 && char3 == char4;
    }

    private char[][] parseArrayToMatrix(String[] dna) {
        char[][] matRet = new char[dna.length][dna.length];
        int cont = 0;
        for (String itDna : dna) {
            matRet[cont] = itDna.toCharArray();
            cont++;
        }
        return matRet;
    }
}
