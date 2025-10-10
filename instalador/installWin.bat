@echo off
REM =========================================================
REM Instalador do projeto SiGMa
REM Versão do instalador: v1.0 (Windows)
REM =========================================================

echo.
echo ========================================
echo  Instalador do projeto SiGMa - v1.0
echo ========================================
echo.

REM --- Verifica se o PostgreSQL está instalado ---
where psql >nul 2>nul
if %errorlevel% neq 0 (
    echo PostgreSQL não encontrado.
    echo Por favor, instale o PostgreSQL manualmente:
    echo https://www.postgresql.org/download/windows/
    echo.
    pause
    goto :EOF
)

REM --- Verifica se o Java está instalado ---
where java >nul 2>nul
if %errorlevel% neq 0 (
    echo Java não encontrado.
    echo Por favor, instale o Java Runtime Environment (JRE) ou JDK.
    echo Link oficial: https://adoptium.net/
    echo.
    pause
    goto :EOF
)

REM --- Criação do banco de dados ---
echo.
echo Criando banco de dados 'sigmadb'...
echo (caso já exista, esta etapa será ignorada)
echo.

REM Tenta criar o banco; ignora erro se já existir
psql -U postgres -c "CREATE DATABASE sigmadb;" 2>nul

REM --- Importação do arquivo SQL ---
if exist sigmadb.sql (
    echo Importando estrutura do banco...
    psql -U postgres -d sigmadb -f sigmadb.sql
) else (
    echo Arquivo sigmadb.sql nao encontrado.
    echo Certifique-se de que ele está na mesma pasta que este instalador.
    pause
    goto :EOF
)

echo.
echo ========================================
echo  Instalacao concluida com sucesso!
echo ========================================
echo.
pause
