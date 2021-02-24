library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity somador4bit is
    Port ( a : in STD_LOGIC_VECTOR (4 downto 0);
           b : in STD_LOGIC_VECTOR (4 downto 0);
           resultado : out STD_LOGIC_VECTOR (4 downto 0));
end somador4bit;

architecture Behavioral of somador4bit is
    signal coutT : STD_LOGIC_VECTOR (4 downto 0);
component somador1bit
    Port ( a : in STD_LOGIC;
           b : in STD_LOGIC;
           cin : in std_logic;
           cout: out std_logic;
           saida : out STD_LOGIC);
end component;

begin
    soma0: somador1bit port map (a => a(0), b => b(0), cin => '0', cout => coutT(0), saida => resultado(0));
    soma1: somador1bit port map (a => a(1), b => b(1), cin => coutT(0), cout => coutT(1), saida => resultado(1));
    soma2: somador1bit port map (a => a(2), b => b(2), cin => coutT(1), cout => coutT(2), saida => resultado(2));
    soma3: somador1bit port map (a => a(3), b => b(3), cin => coutT(2), cout => coutT(3), saida => resultado(3));
    soma4: somador1bit port map (a => a(4), b => b(4), cin => coutT(3), cout => coutT(4), saida => resultado(4));
end Behavioral;
