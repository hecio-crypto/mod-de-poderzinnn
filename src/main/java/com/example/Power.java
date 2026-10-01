package com.example;

import java.util.Random;

public enum Power {
    TELECINESE("Telecinese", 4.5, PowerRarity.INCOMUM),
    TELEPATIA("Telepatia", 3.5, PowerRarity.RARO),
    INVISIBILIDADE("Invisibilidade", 4.0, PowerRarity.INCOMUM),
    SUPERFORCA("Superforça", 8.0, PowerRarity.COMUM),
    SUPERVELOCIDADE("Supervelocidade", 6.0, PowerRarity.INCOMUM),
    VOO("Voo", 5.0, PowerRarity.INCOMUM),
    TELETRANSPORTE("Teletransporte", 2.5, PowerRarity.RARO),
    VIAGEM_NO_TEMPO("Viagem no tempo", 0.3, PowerRarity.LENDARIO),
    MANIPULACAO_FOGO("Manipulação do fogo", 7.0, PowerRarity.COMUM),
    MANIPULACAO_AGUA("Manipulação da água", 7.0, PowerRarity.COMUM),
    MANIPULACAO_GELO("Manipulação do gelo", 6.0, PowerRarity.INCOMUM),
    MANIPULACAO_ELETRICIDADE("Manipulação da eletricidade", 5.0, PowerRarity.INCOMUM),
    MANIPULACAO_VENTO("Manipulação do vento", 6.0, PowerRarity.INCOMUM),
    MANIPULACAO_TERRA("Manipulação da terra", 7.0, PowerRarity.COMUM),
    MANIPULACAO_LUZ("Manipulação da luz", 2.0, PowerRarity.RARO),
    MANIPULACAO_SOMBRAS("Manipulação das sombras", 2.0, PowerRarity.RARO),
    CURA_ACELERADA("Cura acelerada", 5.0, PowerRarity.INCOMUM),
    REGENERACAO("Regeneração", 2.0, PowerRarity.RARO),
    IMORTALIDADE("Imortalidade", 0.1, PowerRarity.MITICO),
    CONTROLE_MENTAL("Controle mental", 1.5, PowerRarity.RARO),
    PRECOGNICAO("Precognição", 1.5, PowerRarity.RARO),
    VISAO_DO_FUTURO("Visão do futuro", 0.8, PowerRarity.LENDARIO),
    VISAO_RAIOS_X("Visão através de objetos", 5.0, PowerRarity.INCOMUM),
    CRIACAO_ILUSOES("Criação de ilusões", 3.0, PowerRarity.RARO),
    METAMORFOSE("Metamorfose", 4.0, PowerRarity.INCOMUM),
    CLONAGEM("Clonagem", 2.0, PowerRarity.RARO),
    ABSORCAO_ENERGIA("Absorção de energia", 1.5, PowerRarity.RARO),
    EMISSAO_ENERGIA("Emissão de energia", 3.0, PowerRarity.RARO),
    CRIACAO_PORTAIS("Criação de portais", 1.0, PowerRarity.LENDARIO),
    CONTROLE_GRAVIDADE("Controle da gravidade", 0.7, PowerRarity.LENDARIO),
    MANIPULACAO_ESPACO("Manipulação do espaço", 0.4, PowerRarity.LENDARIO),
    MANIPULACAO_REALIDADE("Manipulação da realidade", 0.1, PowerRarity.MITICO),
    CONTROLE_PLANTAS("Controle de plantas", 8.0, PowerRarity.COMUM),
    COMUNICACAO_ANIMAIS("Comunicação com animais", 8.0, PowerRarity.COMUM),
    CONTROLE_ANIMAIS("Controle de animais", 6.0, PowerRarity.INCOMUM),
    RESPIRACAO_SUBAQUATICA("Respiração subaquática", 9.0, PowerRarity.COMUM),
    ADAPTACAO_CORPORAL("Adaptação corporal", 4.0, PowerRarity.INCOMUM),
    ELASTICIDADE("Elasticidade", 7.0, PowerRarity.COMUM),
    INTANGIBILIDADE("Intangibilidade", 1.5, PowerRarity.RARO),
    SUPER_SENTIDOS("Super sentidos", 9.0, PowerRarity.COMUM),
    CAMPOS_DE_FORCA("Criação de campos de força", 2.0, PowerRarity.RARO),
    ABSORCAO_PODERES("Absorção de poderes", 0.5, PowerRarity.LENDARIO),
    ANULACAO_PODERES("Anulação de poderes", 0.5, PowerRarity.LENDARIO),
    CONTROLE_SONHOS("Controle de sonhos", 1.0, PowerRarity.LENDARIO),
    PROJECAO_ASTRAL("Projeção astral", 2.0, PowerRarity.RARO),
    MANIPULACAO_MEMORIAS("Manipulação de memórias", 0.8, PowerRarity.LENDARIO),
    RESSURREICAO("Ressurreição", 0.1, PowerRarity.MITICO),
    CRIACAO_MATERIA("Criação de matéria", 0.3, PowerRarity.LENDARIO),
    MANIPULACAO_SOM("Manipulação do som", 5.0, PowerRarity.INCOMUM),
    MANIPULACAO_TEMPO("Manipulação do tempo", 0.2, PowerRarity.MITICO);

    private final String displayName;
    private final double chance;
    private final PowerRarity rarity;

    Power(String displayName, double chance, PowerRarity rarity) {
        this.displayName = displayName;
        this.chance = chance;
        this.rarity = rarity;
    }

    public String getDisplayName() { return displayName; }
    public double getChance() { return chance; }
    public PowerRarity getRarity() { return rarity; }

    // Árvore de Habilidades (6 Formas de uso para este poder)
    public String[] getSkillTreeForms() {
        return new String[]{
            "Forma 1: Habilidade Básica / Passiva",
            "Forma 2: Disparo / Ataque Direto",
            "Forma 3: Escudo / Defesa Pessoal",
            "Forma 4: Explosão de Área (AoE)",
            "Forma 5: Despertar / Suporte Avançado",
            "Forma 6: Habilidade Suprema (Ultimate)"
        };
    }

    // Algoritmo de sorteio aleatório por porcentagem
    public static Power rollRandomPower(Random random) {
        double totalWeight = 0;
        for (Power p : Power.values()) {
            totalWeight += p.getChance();
        }

        double rolledValue = random.nextDouble() * totalWeight;
        double accumulatedWeight = 0;

        for (Power p : Power.values()) {
            accumulatedWeight += p.getChance();
            if (rolledValue <= accumulatedWeight) {
                return p;
            }
        }
        return SUPER_SENTIDOS;
    }
}
