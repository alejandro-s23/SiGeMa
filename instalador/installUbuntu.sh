#!/usr/bin/env bash
#
#=============================
#Instalador do projeto SiGma
#Versão do instalador: v1.0
#=============================
#
if [[ ! -x $(which postgresql) ]]; then 
  echo "======================================"
  echo "Instalando o Banco de Dados"
  echo "======================================"
  sudo apt update > /dev/null
  sudo apt install postgresql postgresql-contrib -y
fi

if [[ ! -x $(which java) ]]; then
  echo "======================================"
  echo "Instalando o Java JRE"
  echo "======================================"
  sudo apt update > /dev/null
  sudo apt install default-jre -y
fi

#Criação do banco de dados
echo "======================================"
echo "Criando o Banco de Dados do SiGMa"
echo "======================================"

sudo -u postgres createdb -U postgres sigmadb
[[ -f "sigmadb.sql" ]] && sudo -u postgres psql -U postgres -v usuario="$(whoami)" -d sigmadb -f sigmadb.sql