for folder in $@; do
    echo
    echo $folder
    cd $folder
    ../z/convert-to-pdf.bash
    cd ..
done

