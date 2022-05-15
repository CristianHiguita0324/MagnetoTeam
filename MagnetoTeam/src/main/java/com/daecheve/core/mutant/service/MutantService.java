package com.daecheve.core.mutant.service;

import com.daecheve.core.mutant.model.MutantModel;
import com.daecheve.core.mutant.port.MutantPort;
import java.util.Arrays;
import java.util.List;

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
        
        MutantModel mutantModel = new MutantModel();
        mutantModel.setDna(Arrays.toString(dna));
        mutantModel.setIsMutant(Byte.parseByte(answer ? "1" : "0"));
        mutantPort.save(mutantModel);
        
        return answer;
    }
    
    public List<MutantModel> findAllMutant(){
        return mutantPort.findAll();
    }
    
    private boolean matchDna(char[][] dna) {
        int contMutant = 0;
        
        for (int y = 0; y < dna.length; y++) {
            for (int x = 0; x < dna.length; x++) {
                
                if (findAxisX(x, y, dna) || findAxisY(x, y, dna) || findAxisXY(x, y, dna)) {
                    contMutant++;
                }
                
                if (contMutant > 1) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean findAxisX(int x, int y, char[][] dna) {
        return x < dna.length - 3 && Boolean.TRUE.equals(compareSequence(dna[y][x], dna[y][x + 1], dna[y][x + 2], dna[y][x + 3]));
    }
    
    private boolean findAxisY(int x, int y, char[][] dna) {
        return y < dna.length - 3 && Boolean.TRUE.equals(compareSequence(dna[y][x], dna[y + 1][x], dna[y + 2][x], dna[y + 3][x]));
    }
    
    private boolean findAxisXY(int x, int y, char[][] dna) {
        boolean answer = false;
        if (x < dna.length - 3 && y < dna.length - 3) {
            if (Boolean.TRUE.equals(compareSequence(dna[y][x], dna[y + 1][x + 1], dna[y + 2][x + 2], dna[y + 3][x + 3]))) {
                return true;
            }
            
            if (Boolean.TRUE.equals(compareSequence(dna[y][5 - x], dna[y + 1][4 - x], dna[y + 2][3 - x], dna[y + 3][2 - x]))) {
                return true;
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
