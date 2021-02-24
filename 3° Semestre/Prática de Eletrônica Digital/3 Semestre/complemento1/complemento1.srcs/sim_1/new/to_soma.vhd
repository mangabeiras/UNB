library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity tb_soma4 is
  
end tb_soma4;

architecture Behavioral of tb_soma4 is

component somador4b is
    Port ( A : in STD_LOGIC_VECTOR (3 downto 0);
           B : in STD_LOGIC_VECTOR (3 downto 0);
           SEL: in STD_LOGIC;
           Cin : in STD_LOGIC;
           S : inout STD_LOGIC_VECTOR (3 downto 0);
           Cout : out STD_LOGIC;
           overflow: out std_logic);
end component;

    signal s_A, S_B, S_S: STD_LOGIC_VECTOR (3 downto 0);
    signal s_C,s_SEL, s_COUT, s_overflow: STD_LOGIC;

begin
    uuu: somador4b port map (A=>s_a , B=>s_b ,SEL =>s_SEL, Cin=>s_C , S => S_S , overflow=>s_overflow);

    stimulus: process 
    
    begin
    
        s_A <= "0010" ; s_B <= "0011"; s_C <= '0'; 
        wait for 10ns;  
        s_A <= "0110" ; s_B <= "0101"; s_C <= '0'; 
        wait for 10ns;
        s_A <= "0101" ; s_B <= "1110"; s_C <= '0'; 
        wait for 10ns;  
        s_A <= "0010" ; s_B <= "1011"; s_C <= '0'; 
        wait for 10ns;
        s_A <= "1101" ; s_B <= "0011"; s_C <= '0'; 
        wait for 10ns;  
        s_A <= "0100" ; s_B <= "0000"; s_C <= '0'; 
        wait for 10ns;
        s_A <= "1111" ; s_B <= "0111"; s_C <= '0'; 
        wait for 10ns;  
        s_A <= "1011" ; s_B <= "0011"; s_C <= '0'; 
        wait for 10ns;
        s_A <= "1001" ; s_B <= "0000"; s_C <= '0'; 
        wait for 10ns;  
        s_A <= "1101" ; s_B <= "1111"; s_C <= '0'; 
        wait for 10ns;
        s_A <= "1011" ; s_B <= "1010"; s_C <= '0'; 
        wait for 10ns;  
        s_A <= "0101" ; s_B <= "1101"; s_C <= '0'; 
        wait for 10ns;
        s_A <= "0101" ; s_B <= "1010"; s_C <= '0'; 
        wait for 10ns;  
        s_A <= "0001" ; s_B <= "0000"; s_C <= '0'; 
        wait for 10ns;
        s_A <= "0101" ; s_B <= "0010"; s_C <= '0'; 
        wait for 10ns;  
        s_A <= "0111" ; s_B <= "0011"; s_C <= '0'; 
        wait for 10ns;
         s_A <= "1011" ; s_B <= "1111"; s_C <= '0'; 
        wait for 10ns;  
        s_A <= "1010" ; s_B <= "1010"; s_C <= '0'; 
        wait for 10ns;
        s_A <= "1011" ; s_B <= "1000"; s_C <= '0'; 
        wait for 10ns;  
        s_A <= "1001" ; s_B <= "0100"; s_C <= '0'; 
        wait for 10ns;
        s_A <= "1110" ; s_B <= "0010"; s_C <= '0'; 
        wait for 10ns;  
        s_A <= "1000" ; s_B <= "0000"; s_C <= '0'; 
        wait for 10ns;
        
        wait;
         
    end process;
end Behavioral;