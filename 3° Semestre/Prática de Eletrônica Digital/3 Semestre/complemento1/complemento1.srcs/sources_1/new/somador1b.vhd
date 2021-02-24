library IEEE;
use IEEE.STD_LOGIC_1164.ALL;


entity somador1b is
    Port ( a : in STD_LOGIC;
           b : in STD_LOGIC;
           cin : in STD_LOGIC;
           s : out STD_LOGIC;
           cout : out STD_LOGIC);
end somador1b;

architecture Behavioral of somador1b is

begin
    s <= (b xor cin) xor a;
    cout <= (a and b) or (cin and a) or (b and cin);
    
end Behavioral;
