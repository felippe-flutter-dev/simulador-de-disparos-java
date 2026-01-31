# 🚀 Java Ballistics Simulator

Um simulador de disparos em ambiente de terminal desenvolvido para estudo aprofundado de **Orientação a Objetos (POO)**, **Hierarquia de Classes** e **Simulação Probabilística**. O projeto foca na interação entre diferentes componentes (Armas, Munições, Pólvoras) para calcular a eficácia de disparos a longas distâncias.



## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem:** Java 17+
* **Coleções Avançadas:** Uso de `LinkedList` para simular o comportamento de um carregador real (LIFO - Last In, First Out).
* **Interface e Abstração:** Contratos de comportamento para ações de disparo através da interface `Fireable`.
* **Enums Dinâmicos:** Gerenciamento de tipos de pólvora e calibres com metadados (multiplicadores de força e descrições).

## 🔫 Funcionalidades

* **Magazine Misto:** Suporte para carregar o pente com diferentes tipos de munição de forma sequencial.
* **Modos de Disparo:** Alternância dinâmica entre `SEMI-AUTOMATIC`, `BURST` e `AUTOMATIC`.
* **Cálculo de Energia (Muzzle Energy):** Cálculo baseado na energia base da munição modificada pelo multiplicador do tipo de pólvora.
* **Simulação de Balística:**
    * **Recoil (Recuo):** Penalidades aplicadas com base no modo de disparo.
    * **Spread (Dispersão):** Erro probabilístico que aumenta com a distância.
    * **Chance de Acerto:** Simulação de alvo a 400m com taxa de sucesso variável.



## 📁 Estrutura de Pacotes

O projeto segue as convenções padrão de pacotes Java:

* `engine`: Orquestrador do jogo e entrada via Scanner.
* `interfaces`: Contratos de comportamento (`Fireable`).
* `enums`: Definições fixas (Calibres, FireModes, GunPowder).
* `model`: Entidades de dados e classes base (`Gun`, `Ammo`, `M4`).

## 🎮 Como Executar

1. Certifique-se de ter o **JDK 17** ou superior instalado.
2. Compile as classes e execute a classe `ShootingEngine.java`.

## 📝 Comandos do Simulador

| Comando | Ação |
| :--- | :--- |
| **ENTER** | Efetua o disparo (consome 1 munição) |
| **m** | Troca o modo de disparo (Semi, Burst ou Auto) |
| **r** | Abre o menu interativo de recarga |
| **q** | Sai do programa com segurança |

## 🧠 Lógica de Precisão

O simulador utiliza uma fórmula de probabilidade para determinar o acerto:

$$ChanceFinal = PrecisaoBase - PenalidadeDistancia - PenalidadeRecuo$$

O modo **AUTOMATIC** reduz drasticamente a chance de acerto devido ao acúmulo de recuo, enquanto o **SEMI-AUTOMATIC** mantém a precisão estável para os 400 metros.

---
⭐ **Desenvolvido por [Felippe](https://www.linkedin.com/in/felippe-pinheiro-de-almeida-739383184/) como projeto de estudo de Java Backend.**
