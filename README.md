xmax
====

###Purpose
    XMAX waveform display for .mseed files

###Configuration
    The main configuration is found in config.xml. File is under
    source control where user can change system paths accordingly

######Data Setup

    Wildcarded mask of data files to load (when no cmd line args given):
```xml
    <DataMask>resources/DATA</DataMask>
```

    Temporary directory to store decompressed traces in the internal format:
```xml
    <TempPath>resources/DATA_TEMP</TempPath>
```

    Quality control data file:
```xml
    <QCdataFile>/home/max/DATA/QC.xml</QCdataFile>
```

    Station data file extras (events, station info, multiplexed data):
```xml
    <EventFileMask>resources/*.ndk</EventFileMask>
    <StationInfoFile>resources/gsn_sta_list</StationInfoFile>
    <ResponsePath>resources/Responses</ResponsePath>
    <AllowMultiplexedData>true</AllowMultiplexedData>
```

######View Setup

    Show big cursor and status bar:
```xml
    <ShowBigCursor>true</ShowBigCursor>
    <ShowStatusBar>true</ShowStatusBar>
```

    Show command buttons:
```xml
    <ShowCommandButtons>true</ShowCommandButtons>
    <ShowCommandButtonsTop>false</ShowCommandButtonsTop>
```

    Panel order and count (trace, network, station, channel):
```xml
    <PanelCountUnit>1</PanelCountUnit>
    <UnitsInFrame>1</UnitsInFrame>
```

######SessionData Setup
    
    Frame position and dimensions:
```xml
    <State>NORMAL</State>
    <PosY>25</PosY>
    <PoxX>96</PosX>
    <Width>1373</Width>
    <Heighth>789</Heighth>
```

    Set user directories (will change per server):
```xml
    <MSEED>/Users/mth/mth/Projects/xmax</MSEED>
    <ASCII>/Users/mth/mth/Projects/xmax</ASCII>
    <SAC>/Users/mth/mth/Projects/xmax</SAC> 
```

###Usage

######Basic Execution

    No arguments specified (reads data from resources/DATA in config.xml):
```ruby
```java
    java -Xms512M -Xmx512M -jar xmax.jar
```
```
