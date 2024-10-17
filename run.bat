@echo off
SET proj=%~dp0
SET tarjar=target\CIMB-Peerapat_Channak.jar
SET marjar=out\CIMB-Peerapat_Channak.jar
SET run=%proj%%tarjar%
IF NOT EXIST %run% ( SET run=%proj%%marjar%)

echo %run%
java -jar %run%

