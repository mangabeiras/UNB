library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity displayMux is
    Port ( A : in STD_LOGIC_VECTOR (3 downto 0);
           B : in STD_LOGIC_VECTOR (3 downto 0);
           seg : out STD_LOGIC_VECTOR (6 downto 0);
           sel : in STD_LOGIC);
end displayMux;

architecture Behavioral of displayMux is
    signal saida : STD_LOGIC_VECTOR (3 downto 0);
component mux2
    Port ( a : in STD_LOGIC_VECTOR (3 downto 0);
           b : in STD_LOGIC_VECTOR (3 downto 0);
           z : out STD_LOGIC_VECTOR (3 downto 0);
           sel : in STD_LOGIC);
end component;

component decodificadorBCD
    Port ( a : in STD_LOGIC_VECTOR (3 downto 0);
           seg : out STD_LOGIC_VECTOR (6 downto 0));
end component;

begin

    mux01: mux2 port map (a => a, b => b, sel => sel, z => saida);
    deco01: decodificadorBCD port map (a => saida, seg => seg);
    
end Behavioral;
