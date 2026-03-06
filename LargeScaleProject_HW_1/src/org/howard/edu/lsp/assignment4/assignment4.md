Class: Aircraft

    Responsibilities:
    - Store Aircraft type and Flight data

    Collaborators:
    - Transponder

Class: Transponder

    Responsiblities:
    - Packages aircraft type and flight data in high density packets
    - Broadcast to ATC-Groundstation

    Collaborators:
    - ATC-Groundstation

Class: ATC-Groundstation

    Responsibilities:
    - Receives data from transponder
    - Decode data
    - Stores information in database

    Collaborators:
    - Aircraft-Database

Class: Aircraft-Database

    Responsibilities:
    - Stores and manages flight data

Class: Display-system

    Responsibilities:
    - Displays Information
    - Update every 10 seconds for controller

    Collaborators:
    - Aircraft-Database
    - AT-Controller

Class: System-Analyzer

    Responsibilities:
    - Analyzes information to detect danger
    - Alert air traffic controller

    Collaborators:
    - ATC-groundstation
    - AT-Controller

Class: AT-Controller

    Responsibilities:
    - Query Database 
    - Display on screen

    Collaborators:
    - Display-System
    - Aircraft-Database
