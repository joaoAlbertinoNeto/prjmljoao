#!/bin/bash
# This script sets up a Python virtual environment and installs required packages.

python3 -m venv .venv
source .venv/bin/activate
pip install -r requirements
streamlit run app.py