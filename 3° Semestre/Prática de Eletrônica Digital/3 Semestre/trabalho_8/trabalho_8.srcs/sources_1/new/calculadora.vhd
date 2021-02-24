library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity calculadora is
    Port ( bcd_centena: in STD_LOGIC_VECTOR (4 downto 0);--- OPERADOR 2
           bcd_milhares: in STD_LOGIC_VECTOR (4 downto 0);---- OPERADOR 1
           led: out STD_LOGIC;
           clk : in STD_LOGIC; 
           an: out STD_LOGIC_VECTOR (3 downto 0);
           dp: out std_logic;
           M : in STD_LOGIC;
           seg: out STD_LOGIC_VECTOR (6 downto 0));
end calculadora;

architecture Behavioral of calculadora is

component clock
    Port ( clk : in STD_LOGIC; 
           bcd_unidade: in STD_LOGIC_VECTOR (3 downto 0); 
           bcd_dezena: in STD_LOGIC_VECTOR (3 downto 0); 
           bcd_centena: in STD_LOGIC_VECTOR (3 downto 0);
           bcd_milhares: in STD_LOGIC_VECTOR (3 downto 0);
           an: out STD_LOGIC_VECTOR (3 downto 0);
           seg: out STD_LOGIC_VECTOR (6 downto 0);
           dp: out std_logic);
end component;

component somador4bit
    Port ( a : in STD_LOGIC_VECTOR (4 downto 0);
           b : in STD_LOGIC_VECTOR (4 downto 0);
           resultado : out STD_LOGIC_VECTOR (4 downto 0));
end component;

component transformador
    Port ( a : in STD_LOGIC_VECTOR (4 downto 0);
           bcd_1 : out STD_LOGIC_VECTOR (3 downto 0);
           bcd_2 : out STD_LOGIC_VECTOR (3 downto 0));
end component;

component OverFlow
    Port ( a : in STD_LOGIC;
           b : in STD_LOGIC;
           c : in STD_LOGIC;
           saida : out STD_LOGIC);
end component;

component sumOrSub
    Port ( M : in STD_LOGIC;
           bcd : in STD_LOGIC_VECTOR (4 downto 0);
           saida : out STD_LOGIC_VECTOR (4 downto 0));
end component;

component completa
    Port ( bcd1 : in STD_LOGIC_VECTOR (4 downto 0);
           bcd2 : in STD_LOGIC_VECTOR (4 downto 0);
           saida1 : out STD_LOGIC_VECTOR (4 downto 0);
           saida2 : out STD_LOGIC_VECTOR (4 downto 0));
end component;

component retiraSinal
    Port ( bcd1 : in STD_LOGIC_VECTOR (4 downto 0);
           bcd2 : in STD_LOGIC_VECTOR (4 downto 0);
           saida1 : out STD_LOGIC_VECTOR (3 downto 0);
           saida2 : out STD_LOGIC_VECTOR (3 downto 0));
end component;

    signal resultadoSoma: STD_LOGIC_VECTOR (4 downto 0);
    signal centena_now, milhares_now, centena_now1: STD_LOGIC_VECTOR (4 downto 0);
    signal centenaSS, milharesSS, dezena_now, unidade_now: STD_LOGIC_VECTOR (3 downto 0);
    
begin
    completarNum: completa port map (bcd1 => bcd_milhares, bcd2 => bcd_centena, saida1 => milhares_now, saida2 => centena_now);
    subOrSoma: sumOrSub port map (M => M, bcd => centena_now, saida => centena_now1);
    soma: somador4bit port map(a => milhares_now, b => centena_now1, resultado => resultadoSoma);
    transforma: transformador port map(a => resultadoSoma, bcd_1 => dezena_now, bcd_2 => unidade_now);
    isOver: OverFlow port map(a => bcd_milhares(3), b => bcd_centena(3), c => resultadoSoma(3), saida => led);
    tiraSinal: retiraSinal port map (bcd1 => milhares_now, bcd2 => centena_now, saida1 => milharesSS, saida2 => centenaSS);
    clock100: clock port map (clk => clk, bcd_unidade => unidade_now, bcd_dezena => dezena_now, bcd_centena => centenaSS, bcd_milhares => milharesSS, an => an, seg => seg, dp => dp);
end Behavioral;
