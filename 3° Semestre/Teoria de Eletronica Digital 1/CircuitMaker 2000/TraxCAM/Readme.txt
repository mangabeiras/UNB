=================================================================

                  TraxCAM Readme File         8-May-2000

=================================================================

TraxCAM and TraxCAM PRO are provided as additions to CircuitMaker 
2000 (Standard Edition) and CircuitMaker 2000 (Professional 
Edition). These are specially licensed versions of CAMCAD, which 
is a product of Router Solutions, Inc.

TraxCAM is included with CircuitMaker 2000 (Standard Edition)
TraxCAM PRO is included with CircuitMaker 2000 (Professional 
Edition)

TraxCAM has the ability to load, view and print Gerber files and 
Excellon N/C drill files. This provides you the opportunity to 
examine these files graphically before sending them to your board 
manufacturer. 
TraxCAM PRO provides the additional ability to further refine (edit)
those files.

The basic CAMCAD software from Router Solutions contains limited 
functionality with the option of purchasing numerous additional 
features. Some of these features have been added to TraxCAM and 
TraxCAM PRO through a special licensing agreement. Some of the 
features of the basic CAMCAD software are:

CAMCAD (basic)
==============
- Allows you to read the following files:
    Aperture
    DXF
    Gerber
    HPGL/HPGL2
- Allows you to view the files in various modes


The *ADDITIONAL* features of TraxCAM and TraxCAM PRO are:

TraxCAM
=======
- Allows you to print
- Allows you to read Excellon N/C drill files

TraxCAM PRO
===========
- Allows you to print
- Allows you to read Excellon N/C drill files
- Allows you to write the following files:
    Aperture
    DXF
    Excellon N/C Drill
    Gerber
    HPGL/HPGL2
- Allows you to add/edit primitives, add copper pours, etc.
- Allows you to query items

The additional features of TraxCAM PRO are especially useful if 
you need to make certain modifications to the board, which are 
not directly supported by TraxMaker.

Numerous other features are available for purchase directly from 
Router Solutions, Inc. For more information, including where to 
order, choose Help > About CAMCAD...

====================
Instructions for Use
====================

TraxCAM and TraxCAM PRO include an online help file which 
provide information about how to use the product. Here we will 
provide a brief description of how to load and view Gerber and 
drill files.

Creating Gerber and Drill Files
===============================
This is done in TraxMaker:

File > Create Gerber File...
       Create N/C Drill File...

The simplest method is to create Gerber files with the "Embedded 
Apertures (RS274X)" option enabled and to create N/C Drill files 
with the "Create New Tool File" option enabled. These files can 
then be viewed in TraxCAM. Refer to the TraxMaker User Manual 
for more information.

Loading a Gerber File
=====================
1. In TraxCAM, choose File > Import.
2. Select "Gerber Read" and click OK.
3. Browse to find one of the Gerber files (example: Demo.GTL) 
   and click Open.
4. The Gerber Format dialog box appears. Click OK.
5. Click "Place at ORIGIN and FIT PAGE to Image".

This process can be repeated as needed to load and view other 
layers.

Loading a Drill File
====================
1. Using the Notepad editor open the Tool file created by TraxMaker 
   (example: Demo.TOL). Note the tool numbers and sizes 
   (example: T01   30). Exit Notepad.
2. In TraxCAM, choose File > Import
3. Select "Excellon Drill&Route Read" and click OK.
4. Browse to find the ASCII version of the Drill file (example: 
   Demo.TXT)and click Open. Note: TraxCAM cannot read the binary 
   (.DRL) file.
5. The Excellon Import Format dialog box appears. Click OK.
6. Click "Place at ORIGIN and FIT PAGE to Image". The drill holes 
   are now shown, but the sizes will be incorrect.
7. Choose Tools > Tool List.
8. Click on the first Tool Name (T01), then click Edit. Enter the 
   size of this tool determined in step 1, then click OK. Repeat 
   for each tool.
9. Click Close. The correct tool sizes will now be shown.


=================
Technical Support
=================

Questions concerning the use of these products should be 
directed to:

CircuitMaker Customer Support
Phone: 801-224-0433
Fax:   801-224-0545
Email: support@circuitmaker.com
