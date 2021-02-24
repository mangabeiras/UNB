--SOMADOR/SUBTRATOR
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity somador4b is
    Port ( A : in STD_LOGIC_VECTOR (3 downto 0);
           B : in STD_LOGIC_VECTOR (3 downto 0);
           SEL: in STD_LOGIC;
           Cin : in STD_LOGIC;
           S : inout STD_LOGIC_VECTOR (3 downto 0);
           Cout : out STD_LOGIC;
           overflow: out std_logic);
end somador4b;

architecture Behavioral of somador4b is
    signal c0, c1, c2, c3, c4, c5, c6, c7: STD_LOGIC;
    signal compleUm1, compleUm2, compleUm3, compleUm4: STD_LOGIC;
    signal compleDois1, compleDois2, compleDois3, compleDois4: STD_LOGIC;
    
    component somador1b
    Port ( a : in STD_LOGIC;
           b : in STD_LOGIC;
           cin : in STD_LOGIC;
           s : out STD_LOGIC;
           cout : out STD_LOGIC);
end component;

    component complemento1
    Port ( a : in STD_LOGIC;
           sel: in STD_LOGIC;
           s : out STD_LOGIC);
end component;

begin
    compUm1: complemento1 port map (a => B(0), sel => SEL, s => compleUm1);
    somaComp1: somador1b port map (a => compleUm1, b => SEL, cin => Cin, s => compleDois1, cout => c1);
    sub1: somador1b port map (a => A(0), b => compleDois1, cin => c1, s => S(0), cout => c2);
    
    compUm2: complemento1 port map (a => B(1), sel => SEL, s => compleUm2);
    somaComp2: somador1b port map (a => compleUm2, b => SEL, cin => c2, s => compleDois2, cout => c3);
    sub2: somador1b port map (a => A(1), b => compleDois2, cin => c3, s => S(1), cout => c4);
    
    comp3: complemento1 port map (a => B(2), sel => SEL, s => compleUm3);
    somaComp3: somador1b port map (a => compleUm3, b => SEL, cin => c4, s => compleDois3, cout => c5);
    sub3: somador1b port map (a => A(2), b => compleDois3, cin => c5, s => S(2), cout => c6);
    
    comp4: complemento1 port map (a => B(3), sel => SEL, s => compleUm4);
    somaComp4: somador1b port map (a => compleUm4, b => SEL, cin => c6, s => compleDois4, cout => c7);
    sub4: somador1b port map (a => A(3), b => compleDois4, cin => c7, s => S(3), cout => Cout);
    
    overflow <= ( ( A(3) and B(3) ) OR (  NOT (A(3) AND B(3)) ) ) AND S(3);
    
end Behavioral;
