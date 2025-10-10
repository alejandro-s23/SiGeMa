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

#Criando um usuario novo
sudo -u postgres psql -c "CREATE USER $(whoami) WITH SUPERUSER PASSWORD 'senha123';"
#Criando o banco de dados
createdb -U $(whoami) sigmadb
#Copiando a template para o novo banco de dados
psql -U $(whoami) -v usuario="$(whoami)" -d sigmadb -f $(pwd)/sigmadb.sql